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

import com.jgeppert.struts2.jquery.components.Radio;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 * @see Radio
 */

public class RadioTag extends AbstractFormListElementTag {

    private static final long serialVersionUID = 5405919375440859551L;

    protected String buttonset;
    protected String icon;
    protected String direction;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Radio(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        Radio radio = (Radio) component;
        radio.setButtonset(buttonset);
        radio.setIcon(icon);
        radio.setDirection(direction);
    }

    public void setButtonset(String buttonset) {
        this.buttonset = buttonset;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
