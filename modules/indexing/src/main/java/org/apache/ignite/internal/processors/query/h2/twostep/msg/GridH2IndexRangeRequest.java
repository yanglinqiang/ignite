/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.query.h2.twostep.msg;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.UUID;
import org.apache.ignite.internal.GridDirectMap;
import org.apache.ignite.internal.util.GridMessageList;
import org.apache.ignite.plugin.extensions.communication.Message;
import org.apache.ignite.plugin.extensions.communication.MessageReader;
import org.apache.ignite.plugin.extensions.communication.MessageWriter;

/**
 *
 */
public class GridH2IndexRangeRequest implements Message {
    /** */
    private long id;

    /** */
    private UUID originNodeId;

    /** */
    private long qryId;

    /** Range ID to search row pair mapping. */
    @GridDirectMap(keyType = Message.class, valueType = Message.class)
    private Map<GridH2Integer,GridMessageList<GridH2RowMessage>> searchRows;

    public Map<GridH2Integer,GridMessageList<GridH2RowMessage>> searchRows() {
        return searchRows;
    }

    public void searchRows(Map<GridH2Integer,GridMessageList<GridH2RowMessage>> searchRows) {
        this.searchRows = searchRows;
    }

    public UUID originNodeId() {
        return originNodeId;
    }

    public void originNodeId(UUID originNodeId) {
        this.originNodeId = originNodeId;
    }

    public long queryId() {
        return qryId;
    }

    public void queryId(long qryId) {
        this.qryId = qryId;
    }

    /** {@inheritDoc} */
    @Override public boolean writeTo(ByteBuffer buf, MessageWriter writer) {
        return false;
    }

    /** {@inheritDoc} */
    @Override public boolean readFrom(ByteBuffer buf, MessageReader reader) {
        return false;
    }

    /** {@inheritDoc} */
    @Override public byte directType() {
        return -23;
    }

    /** {@inheritDoc} */
    @Override public byte fieldsCount() {
        return 0;
    }
}