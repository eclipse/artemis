/*
 *  Copyright (c) 2017 Otávio Santana and others
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   and Apache License v2.0 which accompanies this distribution.
 *   The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *   and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 *   You may elect to redistribute this code under either of these licenses.
 *
 *   Contributors:
 *
 *   Otavio Santana
 */
package org.jnosql.artemis.reflection;

import org.jnosql.artemis.AttributeConverter;
import org.jnosql.diana.api.TypeSupplier;

import java.lang.reflect.Field;

class FieldRepresentationBuilder {

    private FieldType type;

    private Field field;

    private String name;

    private String entityName;

    private TypeSupplier<?> typeSupplier;

    private Class<? extends AttributeConverter> converter;

    private boolean id;

    private FieldReader reader;

    private FieldWriter writer;


    public FieldRepresentationBuilder withType(FieldType type) {
        this.type = type;
        return this;
    }

    public FieldRepresentationBuilder withField(Field field) {
        this.field = field;
        return this;
    }

    public FieldRepresentationBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public FieldRepresentationBuilder withTypeSupplier(TypeSupplier<?> typeSupplier) {
        this.typeSupplier = typeSupplier;
        return this;
    }

    public FieldRepresentationBuilder withEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public FieldRepresentationBuilder withConverter(Class<? extends AttributeConverter> converter) {
        this.converter = converter;
        return this;
    }

    public FieldRepresentationBuilder withId(boolean id) {
        this.id = id;
        return this;
    }

    public FieldRepresentationBuilder withWriter(FieldWriter writer) {
        this.writer = writer;
        return this;
    }

    public FieldRepresentationBuilder withReader(FieldReader reader) {
        this.reader = reader;
        return this;
    }

    public DefaultFieldMapping buildDefault() {
        return new DefaultFieldMapping(type, field, name, converter, id, reader, writer);
    }

    public GenericFieldMapping buildGeneric() {
        return new GenericFieldMapping(type, field, name, typeSupplier, converter, reader, writer);
    }

    public EmbeddedFieldMapping buildEmedded() {
        return new EmbeddedFieldMapping(type, field, name, entityName, reader, writer);
    }

}
