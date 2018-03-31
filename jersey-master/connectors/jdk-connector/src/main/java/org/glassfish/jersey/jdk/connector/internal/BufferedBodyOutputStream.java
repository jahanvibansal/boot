/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2015-2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.glassfish.jersey.jdk.connector.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author Petr Janouch (petr.janouch at oracle.com)
 */
class BufferedBodyOutputStream extends BodyOutputStream {

    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    /* This whole mode stuff is totally pointless if we buffer the request body,
    it is here only in case someone complained that this stream does not behave as BodyOutputStream says it should */
    private volatile Mode mode = Mode.UNDECIDED;

    @Override
    public void setWriteListener(WriteListener writeListener) {
        if (mode == Mode.ASYNCHRONOUS) {
            throw new IllegalStateException(LocalizationMessages.WRITE_LISTENER_SET_ONLY_ONCE());
        }

        if (mode == Mode.SYNCHRONOUS) {
            throw new UnsupportedOperationException(LocalizationMessages.ASYNC_OPERATION_NOT_SUPPORTED());
        }

        mode = Mode.ASYNCHRONOUS;
        try {
            writeListener.onWritePossible();
        } catch (IOException e) {
            writeListener.onError(e);
        }
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void write(int b) throws IOException {
        if (mode == Mode.UNDECIDED) {
            mode = Mode.SYNCHRONOUS;
        }

        buffer.write(b);
    }

    ByteBuffer toBuffer() {
        return ByteBuffer.wrap(buffer.toByteArray());
    }

    private enum Mode {
        UNDECIDED,
        ASYNCHRONOUS,
        SYNCHRONOUS
    }
}
