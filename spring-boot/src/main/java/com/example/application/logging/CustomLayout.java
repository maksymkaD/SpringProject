package com.example.application.logging;

import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;

import java.nio.charset.Charset;

@Plugin(name = "CustomLayout", category = Node.CATEGORY, elementType = Layout.ELEMENT_TYPE, printObject = true)
public class CustomLayout  extends AbstractStringLayout
{
    protected CustomLayout( Charset charset )
    {
        super( charset );
    }

    @Override public String toSerializable( LogEvent event )
    {
        return null;
    }
}
