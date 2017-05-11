/*
 * Copyright 2017 Otavio Santana and others
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
package org.jnosql.artemis.key;


import org.jnosql.diana.api.key.KeyValueEntity;

import java.util.function.UnaryOperator;

/**
 * This implementation defines the workflow to insert an Entity on {@link KeyValueTemplate}.
 * The default implementation follows:
 *  <p>{@link KeyValueEventPersistManager#firePreEntity(Object)}</p>
 *  <p>{@link KeyValueEventPersistManager#firePreKeyValueEntity(Object)}</p>
 *  <p>{@link KeyValueEntityConverter#toKeyValue(Object)}</p>
 *  <p>{@link KeyValueEventPersistManager#firePreKeyValue(KeyValueEntity)}</p>
 *  <p>Database alteration</p>
 *  <p>{@link KeyValueEventPersistManager#firePostKeyValue(KeyValueEntity)}</p>
 *  <p>{@link KeyValueEventPersistManager#firePostEntity(Object)}</p>
 *  <p>{@link KeyValueEventPersistManager#firePostKeyValueEntity(Object)}</p>
 */
public interface KeyValueWorkflow {

    /**
     * Executes the workflow to do an interaction on a database key-value.
     *
     * @param entity the entity to be saved
     * @param action the alteration to be executed on database
     * @param <T>    the entity type
     * @return after the workflow the the entity response
     * @see KeyValueTemplate#put(Object, java.time.Duration)  {@link KeyValueTemplate#put(Object)}
     * DocumentTemplate#update(Object)
     */
    <T> T flow(T entity, UnaryOperator<KeyValueEntity<?>> action) throws NullPointerException;
}
