package com.up_and_running.ch3.xstream.props;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author Alexandr Jelimalai
 */
public class PersonPropsConverter implements Converter {

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        PersonProps personProps = (PersonProps)source;
        writer.startNode("Person");
        writer.setValue(personProps.getName());
        writer.endNode();
    }


    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        PersonProps personProps = new PersonProps();
        reader.moveDown();
        personProps.setName(reader.getValue());
        reader.moveUp();
        return personProps;

    }


    @Override
    public boolean canConvert(Class type) {
        return type.equals(PersonProps.class);
    }
}
