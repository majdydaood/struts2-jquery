/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jgeppert.struts2.jquery.components;

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Renders a local or an remote tab for tabbedPanel
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <pre>
 * &lt;s:url id=&quot;remoteurl1&quot; action=&quot;myremoteactionone&quot;/&gt;
 * &lt;sj:tab id=&quot;tab1&quot; target=&quot;tone&quot; label=&quot;My Local Tab for div tone&quot;/&gt;
 * &lt;sj:tab id=&quot;tab2&quot; href=&quot;%{remoteurl1}&quot; label=&quot;My Remote Tab&quot;/&gt;
 * &lt;div id=&quot;tone&quot;&gt; Test 1 &lt;/div&gt;
 * </pre>
 * <!-- END SNIPPET: example1 -->
 *
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "tab", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.TabTag", description = "Render Tab for Tabbed Panel providing content from remote call via AJAX")
public class Tab extends AbstractRemoteBean {

    public static final String TEMPLATE = "tab";
    public static final String TEMPLATE_CLOSE = "tab-close";
    public static final String COMPONENT_NAME = Tab.class.getName();

    private static final String PARAM_PARENT_TABBED_PANEL = "parentTabbedPanel";
    private static final String PARAM_TARGET = "target";
    private static final String PARAM_CLOSABLE = "closable";

    private static final String ID_PREFIX_TAB = "tab_";

    protected String target;
    protected String closable;

    public Tab(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        TabbedPanel parentTabbedPanel = (TabbedPanel) findAncestor(TabbedPanel.class);
        if (parentTabbedPanel != null) {
            addParameter(PARAM_PARENT_TABBED_PANEL, findString(parentTabbedPanel.getId()));
        }
        addParameterIfPresent(PARAM_CLOSABLE, this.closable, Boolean.class);
        addParameterIfPresent(PARAM_TARGET, this.target);

        addGeneratedIdParam(ID_PREFIX_TAB);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setTheme(String theme) {
        super.setTheme(theme);
    }

    @Override
    public String getTheme() {
        return "jquery";
    }

    @StrutsTagAttribute(description = "id of target div for tab")
    public void setTarget(String target) {
        this.target = target;
    }

    @StrutsTagAttribute(description = "If true then tab is closable.", defaultValue = "false", type = "Boolean")
    public void setClosable(String closable) {
        this.closable = closable;
    }

}
