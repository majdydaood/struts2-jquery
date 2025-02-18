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

package com.jgeppert.struts2.jquery.tree.components;

import com.jgeppert.struts2.jquery.components.AbstractContainer;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.util.ContainUtil;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render a Tree Element
 * </p>
 * <!-- END SNIPPET: javadoc -->
 *
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "tree", tldTagClass = "com.jgeppert.struts2.jquery.tree.views.jsp.ui.TreeTag", description = "A Tree Element", allowDynamicAttributes = true)
public class Tree extends AbstractContainer {

    public static final String TEMPLATE = "tree";
    public static final String TEMPLATE_CLOSE = "tree-close";
    public static final String COMPONENT_NAME = Tree.class.getName();
    public static final String JQUERYACTION = "tree";

    private static final String PARAM_JSTREETHEME = "jstreetheme";
    private static final String PARAM_JSTREETHEME_RESPONSIVE = "jstreethemeResponsive";
    private static final String PARAM_JSTREETHEME_VARIANT = "jstreethemeVariant";
    private static final String PARAM_ANIMATION = "animation";
    private static final String PARAM_HTML_TITLES = "htmlTitles";
    private static final String PARAM_INITIALLY_OPEN = "initiallyOpen";
    private static final String PARAM_RTL = "rtl";
    private static final String PARAM_HREF = "href";
    private static final String PARAM_ON_CLICK_TOPICS = "onClickTopics";
    private static final String PARAM_ROOT_NODE = "rootNode";
    private static final String PARAM_CHILD_COLLECTION_PROPERTY = "childCollectionProperty";
    private static final String PARAM_NODE_TITLE_PROPERTY = "nodeTitleProperty";
    private static final String PARAM_NODE_TYPE_PROPERTY = "nodeTypeProperty";
    private static final String PARAM_NODE_ID_PROPERTY = "nodeIdProperty";
    private static final String PARAM_NODE_HREF = "nodeHref";
    private static final String PARAM_NODE_HREF_PARAM_NAME = "nodeHrefParamName";
    private static final String PARAM_NODE_TARGETS = "nodeTargets";
    private static final String PARAM_OPEN_ALL_ON_LOAD = "openAllOnLoad";
    private static final String PARAM_OPEN_ALL_ON_REFRESH = "openAllOnRefresh";
    private static final String PARAM_CONTEXTMENU = "contextmenu";
    private static final String PARAM_PLUGINS = "plugins";
    private static final String PARAM_TYPES = "types";
    private static final String PARAM_SHOW_THEME_DOTS = "showThemeDots";
    private static final String PARAM_SHOW_THEME_ICONS = "showThemeIcons";
    private static final String PARAM_CHECKBOX = "checkbox";
    private static final String PARAM_CHECKBOX_TWO_STATE = "checkboxTwoState";
    private static final String PARAM_CHECKBOX_TOOGLE_ALL_TOPICS = "checkboxToogleAllTopics";
    private static final String PARAM_CHECKBOX_HIDE_TOPICS = "checkboxHideTopics";
    private static final String PARAM_CHECKBOX_SHOW_TOPICS = "checkboxShowTopics";
    private static final String PARAM_CHECKBOX_CHECK_ALL_TOPICS = "checkboxCheckAllTopics";
    private static final String PARAM_CHECKBOX_UNCHECK_ALL_TOPICS = "checkboxUncheckAllTopics";
    private static final String PARAM_SEARCH_TOPIC = "searchTopic";
    private static final String PARAM_SEARCH_ELEMENT_ID = "searchElementId";
    private static final String PARAM_ON_SEARCH_COMPLETE_TOPICS = "onSearchCompleteTopics";
    private static final String PARAM_ON_SEARCH_CLEAR_TOPICS = "onSearchClearTopics";
    private static final String PARAM_SEARCH_CLEAR_TOPIC = "searchClearTopic";

    private static final String ID_PREFIX_TREE = "tree_";

    protected String jstreetheme;
    protected String jstreethemeVariant;
    protected String jstreethemeResponsive;
    protected String htmlTitles;
    protected String animation;
    protected String initiallyOpen;
    protected String rtl;
    protected String href;
    protected String onClickTopics;
    protected String rootNode;
    protected String childCollectionProperty;
    protected String nodeTitleProperty;
    protected String nodeTypeProperty;
    protected String nodeIdProperty;
    protected String nodeHref;
    protected String nodeHrefParamName;
    protected String nodeTargets;
    protected String openAllOnLoad;
    protected String openAllOnRefresh;
    protected String contextmenu;
    protected String plugins;
    protected String types;
    protected String showThemeDots;
    protected String showThemeIcons;
    protected String checkbox;
    protected String checkboxTwoState;
    protected String checkboxToogleAllTopics;
    protected String checkboxHideTopics;
    protected String checkboxShowTopics;
    protected String checkboxCheckAllTopics;
    protected String checkboxUncheckAllTopics;
    protected String searchTopic;
    protected String searchClearTopic;
    protected String searchElementId;
    protected String onSearchCompleteTopics;
    protected String onSearchClearTopics;

    public Tree(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    @Override
    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    @Override
    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    @Override
    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        addParameterIfPresent(PARAM_JSTREETHEME, this.jstreetheme);
        addParameterIfPresent(PARAM_JSTREETHEME_RESPONSIVE, this.jstreethemeResponsive, Boolean.class);
        addParameterIfPresent(PARAM_JSTREETHEME_VARIANT, this.jstreethemeVariant);
        addParameterIfPresent(PARAM_ANIMATION, this.animation, Number.class);
        addParameterIfPresent(PARAM_HTML_TITLES, this.htmlTitles, Boolean.class);
        addParameterIfPresent(PARAM_INITIALLY_OPEN, this.initiallyOpen);
        addParameterIfPresent(PARAM_RTL, this.rtl, Boolean.class);
        addParameterIfPresent(PARAM_HREF, this.href);
        addParameterIfPresent(PARAM_ON_CLICK_TOPICS, this.onClickTopics);
        addParameterIfPresent(PARAM_ROOT_NODE, this.rootNode, Object.class);
        addParameterIfPresent(PARAM_CHILD_COLLECTION_PROPERTY, this.childCollectionProperty);
        addParameterIfPresent(PARAM_NODE_TITLE_PROPERTY, this.nodeTitleProperty);
        addParameterIfPresent(PARAM_NODE_TYPE_PROPERTY, this.nodeTypeProperty);
        addParameterIfPresent(PARAM_NODE_ID_PROPERTY, this.nodeIdProperty);
        addParameterIfPresent(PARAM_NODE_HREF, this.nodeHref);
        addParameterIfPresent(PARAM_NODE_HREF_PARAM_NAME, this.nodeHrefParamName);
        addParameterIfPresent(PARAM_NODE_TARGETS, this.nodeTargets);
        addParameterIfPresent(PARAM_OPEN_ALL_ON_LOAD, this.openAllOnLoad, Boolean.class);
        addParameterIfPresent(PARAM_OPEN_ALL_ON_REFRESH, this.openAllOnRefresh, Boolean.class);
        addParameterIfPresent(PARAM_CONTEXTMENU, this.contextmenu);
        addParameterIfPresent(PARAM_PLUGINS, this.plugins);
        addParameterIfPresent(PARAM_TYPES, this.types);
        addParameterIfPresent(PARAM_SHOW_THEME_DOTS, this.showThemeDots, Boolean.class);
        addParameterIfPresent(PARAM_SHOW_THEME_ICONS, this.showThemeIcons, Boolean.class);
        addParameterIfPresent(PARAM_CHECKBOX, this.checkbox, Boolean.class);
        addParameterIfPresent(PARAM_CHECKBOX_TWO_STATE, this.checkboxTwoState, Boolean.class);
        addParameterIfPresent(PARAM_CHECKBOX_TOOGLE_ALL_TOPICS, this.checkboxToogleAllTopics);
        addParameterIfPresent(PARAM_CHECKBOX_HIDE_TOPICS, this.checkboxHideTopics);
        addParameterIfPresent(PARAM_CHECKBOX_SHOW_TOPICS, this.checkboxShowTopics);
        addParameterIfPresent(PARAM_CHECKBOX_CHECK_ALL_TOPICS, this.checkboxCheckAllTopics);
        addParameterIfPresent(PARAM_CHECKBOX_UNCHECK_ALL_TOPICS, this.checkboxUncheckAllTopics);
        addParameterIfPresent(PARAM_SEARCH_TOPIC, this.searchTopic);
        addParameterIfPresent(PARAM_SEARCH_ELEMENT_ID, this.searchElementId);
        addParameterIfPresent(PARAM_ON_SEARCH_COMPLETE_TOPICS, this.onSearchCompleteTopics);
        addParameterIfPresent(PARAM_ON_SEARCH_CLEAR_TOPICS, this.onSearchClearTopics);
        addParameterIfPresent(PARAM_SEARCH_CLEAR_TOPIC, this.searchClearTopic);

        addGeneratedIdParam(ID_PREFIX_TREE);
    }

    public boolean contains(Object obj1, Object obj2) {
        return ContainUtil.contains(obj1, obj2);
    }

    @Override
    @SuppressWarnings("rawtypes")
    protected Class getValueClassType() {
        return null; // don't convert nameValue to anything, we need the raw
        // value
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

    @StrutsTagAttribute(description = "jstree theme. default, default-rtl, classic or apple", defaultValue = "theme from jquery ui")
    public void setJstreetheme(String jstreetheme) {
        this.jstreetheme = jstreetheme;
    }

    @StrutsTagAttribute(description = "jstree theme variant, if your theme support it.")
    public void setJstreethemeVariant(String jstreethemeVariant) {
        this.jstreethemeVariant = jstreethemeVariant;
    }

    @StrutsTagAttribute(description = "wether to use the responsive version of the theme, if the theme support it", type = "Boolean", defaultValue = "false")
    public void setJstreethemeResponsive(String jstreethemeResponsive) {
        this.jstreethemeResponsive = jstreethemeResponsive;
    }

    @StrutsTagAttribute(description = "Defines whether titles can contain HTML code.", type = "Boolean", defaultValue = "false")
    public void setHtmlTitles(String htmlTitles) {
        this.htmlTitles = htmlTitles;
    }

    @StrutsTagAttribute(description = "Defines the duration of open/close animations. 0 means no animation.", type = "Number", defaultValue = "500")
    public void setAnimation(String animation) {
        this.animation = animation;
    }

    @StrutsTagAttribute(description = "Defines which nodes are to be automatically opened when the tree finishes loading - a list of IDs is expected. eg.: ['id1', 'id2']", defaultValue = "[]")
    public void setInitiallyOpen(String initiallyOpen) {
        this.initiallyOpen = initiallyOpen;
    }

    @StrutsTagAttribute(description = "Defines whether the tree is in right-to-left mode (also make sure you are using a RTL theme - for example the included default-rtl).", type = "Boolean", defaultValue = "false")
    public void setRtl(String rtl) {
        this.rtl = rtl;
    }

    @Override
    @StrutsTagAttribute(description = "Url used to load the list of children nodes for an specific node, whose id will be passed as a parameter named 'nodeId' (empty for root)")
    public void setHref(String href) {
        this.href = href;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the tree item is clicked")
    public void setOnClickTopics(String onClickTopics) {
        this.onClickTopics = onClickTopics;
    }

    @StrutsTagAttribute(description = "The rootNode property.")
    public void setRootNode(String rootNode) {
        this.rootNode = rootNode;
    }

    @StrutsTagAttribute(description = "The childCollectionProperty property.")
    public void setChildCollectionProperty(String childCollectionProperty) {
        this.childCollectionProperty = childCollectionProperty;
    }

    @StrutsTagAttribute(description = "The nodeTitleProperty property.")
    public void setNodeTitleProperty(String nodeTitleProperty) {
        this.nodeTitleProperty = nodeTitleProperty;
    }

    @StrutsTagAttribute(description = "The nodeIdProperty property.")
    public void setNodeIdProperty(String nodeIdProperty) {
        this.nodeIdProperty = nodeIdProperty;
    }

    @StrutsTagAttribute(description = "The type property for node. This needs a valid types definition.")
    public void setNodeTypeProperty(String nodeTypeProperty) {
        this.nodeTypeProperty = nodeTypeProperty;
    }

    @StrutsTagAttribute(description = "The href property for node.")
    public void setNodeHref(String nodeHref) {
        this.nodeHref = nodeHref;
    }

    @StrutsTagAttribute(description = "The href parameter name for node link.", defaultValue = "id")
    public void setNodeHrefParamName(String nodeHrefParamName) {
        this.nodeHrefParamName = nodeHrefParamName;
    }

    @StrutsTagAttribute(description = "AJAX targets for node items.")
    public void setNodeTargets(String nodeTargets) {
        this.nodeTargets = nodeTargets;
    }

    @StrutsTagAttribute(description = "Open all Nodes on load.", type = "Boolean", defaultValue = "false")
    public void setOpenAllOnLoad(String openAllOnLoad) {
        this.openAllOnLoad = openAllOnLoad;
    }

    @StrutsTagAttribute(description = "Open all Nodes on refresh.", type = "Boolean", defaultValue = "false")
    public void setOpenAllOnRefresh(String openAllOnRefresh) {
        this.openAllOnRefresh = openAllOnRefresh;
    }

    @StrutsTagAttribute(description = "Expects an JavaScript object or a function, which should return an JavaScript object. e.g. {items: { 'delete' : { 'label': 'Delete Node', 'action':  function (obj) { this.delete(obj); } } } }")
    public void setContextmenu(String contextmenu) {
        this.contextmenu = contextmenu;
    }

    @StrutsTagAttribute(description = "Expects an JavaScript object containing plugin to activate in key and conf object/function in value. e.g. {search: {ajax : {...}, ...  } , sort : function(n1,n2){...} }. Warning, settings here can override other plugins config defined in other tag attribute (eg : contextmenu)")
    public void setPlugins(String plugins) {
        this.plugins = plugins;
    }

    @StrutsTagAttribute(description = "The types enables node types - each node can have a type, and you can define rules on how that type should behave - maximum children count, maximum depth, valid children types, selectable or not, etc.")
    public void setTypes(String types) {
        this.types = types;
    }

    @StrutsTagAttribute(description = "Whether to show the node icons or not.", type = "Boolean", defaultValue = "true")
    public void setShowThemeIcons(String showThemeIcons) {
        this.showThemeIcons = showThemeIcons;
    }

    @StrutsTagAttribute(description = "Whether to show the connecting dots or not.", type = "Boolean", defaultValue = "true")
    public void setShowThemeDots(String showThemeDots) {
        this.showThemeDots = showThemeDots;
    }

    @StrutsTagAttribute(description = "Makes multiselection possible using three-state checkboxes.", type = "Boolean", defaultValue = "false")
    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox;
    }

    @StrutsTagAttribute(description = "If set to true checkboxes will be two-state only, meaning that you will be able to select parent and children independently and there will be no undetermined state.", type = "Boolean", defaultValue = "false")
    public void setCheckboxTwoState(String checkboxTwoState) {
        this.checkboxTwoState = checkboxTwoState;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics to toogle display of checkboxes.")
    public void setCheckboxToogleAllTopics(String checkboxToogleAllTopics) {
        this.checkboxToogleAllTopics = checkboxToogleAllTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics to hide checkboxes.")
    public void setCheckboxHideTopics(String checkboxHideTopics) {
        this.checkboxHideTopics = checkboxHideTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics to show checkboxes.")
    public void setCheckboxShowTopics(String checkboxShowTopics) {
        this.checkboxShowTopics = checkboxShowTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics to check all checkboxes.")
    public void setCheckboxCheckAllTopics(String checkboxCheckAllTopics) {
        this.checkboxCheckAllTopics = checkboxCheckAllTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics to uncheck all checkboxes.")
    public void setCheckboxUncheckAllTopics(String checkboxUncheckAllTopics) {
        this.checkboxUncheckAllTopics = checkboxUncheckAllTopics;
    }

    @StrutsTagAttribute(description = "The topic that will trigger the tree search")
    public void setSearchTopic(String searchTopic) {
        this.searchTopic = searchTopic;
    }

    @StrutsTagAttribute(description = "The ID of the element that holds the search string")
    public void setSearchElementId(String searchElementId) {
        this.searchElementId = searchElementId;
    }

    @StrutsTagAttribute(description = "comma separated list of topics published when the tree search is complete")
    public void setOnSearchCompleteTopics(String onSearchCompleteTopics) {
        this.onSearchCompleteTopics = onSearchCompleteTopics;
    }

    @StrutsTagAttribute(description = "The topic that will trigger the clear of the last tree search")
    public void setSearchClearTopic(String searchClearTopic) {
        this.searchClearTopic = searchClearTopic;
    }

    @StrutsTagAttribute(description = "comma separated list of topics published when a tree search clear happens")
    public void setOnSearchClearTopics(String onSearchClearTopics) {
        this.onSearchClearTopics = onSearchClearTopics;
    }

}
