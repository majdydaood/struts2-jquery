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

package com.jgeppert.struts2.jquery.views.jsp.ui;

import com.jgeppert.struts2.jquery.components.Head;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 * @see Head
 */
public class HeadTag extends AbstractUITag {

    private static final long serialVersionUID = 6876765769175246030L;

    protected String compressed;
    protected String locale;
    protected String jquery;
    protected String jquerytheme;
    protected String jqueryui;
    protected String customBasepath;
    protected String loadFromCdn;
    protected String ajaxcache;
    protected String ajaxhistory;
    protected String defaultIndicator;
    protected String defaultLoadingText;
    protected String defaultErrorText;
    protected String loadAtOnce;
    protected String debug;
    protected String scriptPath;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Head(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        Head head = (Head) component;
        head.setJquery(jquery);
        head.setJquerytheme(jquerytheme);
        head.setCompressed(compressed);
        head.setJqueryui(jqueryui);
        head.setLocale(locale);
        head.setCustomBasepath(customBasepath);
        head.setLoadFromCdn(loadFromCdn);
        head.setAjaxcache(ajaxcache);
        head.setAjaxhistory(ajaxhistory);
        head.setDefaultIndicator(defaultIndicator);
        head.setDefaultLoadingText(defaultLoadingText);
        head.setDefaultErrorText(defaultErrorText);
        head.setLoadAtOnce(loadAtOnce);
        head.setDebug(debug);
        head.setScriptPath(scriptPath);
    }

    public void setCompressed(String compressed) {
        this.compressed = compressed;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setJquerytheme(String jquerytheme) {
        this.jquerytheme = jquerytheme;
    }

    public void setJquery(String jquery) {
        this.jquery = jquery;
    }

    public void setJqueryui(String jqueryui) {
        this.jqueryui = jqueryui;
    }

    public void setCustomBasepath(String customBasepath) {
        this.customBasepath = customBasepath;
    }

    public void setLoadFromCdn(String loadFromCdn) {
        this.loadFromCdn = loadFromCdn;
    }

    public void setAjaxcache(String ajaxcache) {
        this.ajaxcache = ajaxcache;
    }

    public void setAjaxhistory(String ajaxhistory) {
        this.ajaxhistory = ajaxhistory;
    }

    public void setDefaultIndicator(String defaultIndicator) {
        this.defaultIndicator = defaultIndicator;
    }

    public void setDefaultLoadingText(String defaultLoadingText) {
        this.defaultLoadingText = defaultLoadingText;
    }

    public void setDefaultErrorText(String defaultErrorText) {
        this.defaultErrorText = defaultErrorText;
    }

    public void setLoadAtOnce(String loadAtOnce) {
        this.loadAtOnce = loadAtOnce;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

    public void setScriptPath(String scriptPath) {
        this.scriptPath = scriptPath;
    }
}
