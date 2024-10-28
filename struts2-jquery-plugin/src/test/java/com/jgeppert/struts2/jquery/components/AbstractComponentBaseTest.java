package com.jgeppert.struts2.jquery.components;

import com.opensymphony.xwork2.DefaultTextProvider;
import com.opensymphony.xwork2.conversion.impl.XWorkConverter;
import com.opensymphony.xwork2.ognl.DefaultOgnlBeanInfoCacheFactory;
import com.opensymphony.xwork2.ognl.DefaultOgnlExpressionCacheFactory;
import com.opensymphony.xwork2.ognl.OgnlUtil;
import com.opensymphony.xwork2.ognl.OgnlValueStack;
import com.opensymphony.xwork2.ognl.SecurityMemberAccess;
import com.opensymphony.xwork2.ognl.accessor.CompoundRootAccessor;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.conversion.StrutsTypeConverterHolder;
import org.apache.struts2.ognl.ProviderAllowlist;
import org.apache.struts2.ognl.StrutsOgnlGuard;
import org.apache.struts2.ognl.ThreadAllowlist;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractComponentBaseTest {

    private static final TestXworkConverter converter;

    protected ValueStack valueStack;

    static {
        converter = new TestXworkConverter();
        converter.setTypeConverterHolder(new StrutsTypeConverterHolder());
    }


    @BeforeEach
    void setUpValueStack() {
        valueStack = new TestOgnlValueStack();
    }

    static class TestOgnlValueStack extends OgnlValueStack {
        private static final long serialVersionUID = 1L;

        protected TestOgnlValueStack() {
            super(converter, new CompoundRootAccessor(), new DefaultTextProvider(), new SecurityMemberAccess(new ProviderAllowlist(), new ThreadAllowlist()));

            setOgnlUtil(new OgnlUtil(new DefaultOgnlExpressionCacheFactory<String, Object>(VALUE_STACK, REPORT_ERRORS_ON_NO_PROP), new DefaultOgnlBeanInfoCacheFactory<>(VALUE_STACK, REPORT_ERRORS_ON_NO_PROP), new StrutsOgnlGuard()));
        }

    }

    static class TestXworkConverter extends XWorkConverter {
    }
}
