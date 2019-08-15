
/*
 * Copyright (C) 2011 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.leveldbjni;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.DBFactory;
import java.io.IOException;
import org.iq80.leveldb.impl.Iq80DBFactory;
import java.io.File;
import java.nio.charset.Charset;

public class JniDBFactory implements DBFactory
{
    public static byte[] bytes(String value)
    {
        Charset charset = Charset.forName("UTF-8");
        if (value == null) {
            return null;
        }

        return value.getBytes(charset);
    }

    public static String asString(byte [] value)
    {
        Charset charset = Charset.forName("UTF-8");
        if (value == null) {
            return null;
        }
        return new String(value, charset);
    }

    public DB open(File path, Options options) throws IOException
    {
        options.createIfMissing(true);
        DB db = Iq80DBFactory.factory.open(path, options);
        return db;
    }

    public void destroy(File path, Options options) throws IOException
    {
        //do nothing
    }

    public void repair(File path, Options options) throws IOException
    {
        //do nothing
    }

    @Override
    public String toString()
    {
        return String.format("leveldbjava version 0.13");
    }

    public static void pushMemoryPool(int size)
    {
        //do nothing
    }

    public static void popMemoryPool()
    {
        //do nothing
    }
}
