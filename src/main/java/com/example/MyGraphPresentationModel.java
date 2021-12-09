package com.example;

import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.graph.GraphManager;
import com.intellij.openapi.graph.builder.DeleteProvider;
import com.intellij.openapi.graph.builder.EdgeCreationPolicy;
import com.intellij.openapi.graph.builder.GraphPresentationModel;
import com.intellij.openapi.graph.layout.Layouter;
import com.intellij.openapi.graph.settings.GraphSettings;
import com.intellij.openapi.graph.view.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class MyGraphPresentationModel extends GraphPresentationModel<String, String> {
    private final GraphManager graphManager;
    private final GraphSettings graphSettings;

    public MyGraphPresentationModel(GraphManager graphManager) {
        this.graphManager = graphManager;
        graphSettings = new GraphSettings();
        graphSettings.setCurrentLayouter(Layouter.DUMB_UNAPPLICABLE);
    }

    @Override public @NotNull NodeRealizer getNodeRealizer(@Nullable String s) {
        GenericNodeRealizer genericNodeRealizer = graphManager.createGenericNodeRealizer();
        genericNodeRealizer.setX("Hello".equals(s) ? 0 : 128);
        genericNodeRealizer.setY("Hello".equals(s) ? 0 : 128);
        genericNodeRealizer.setWidth(64);
        genericNodeRealizer.setHeight(64);
        genericNodeRealizer.setLabelText(s);
        return genericNodeRealizer;
    }

    @Override public @NotNull EdgeRealizer getEdgeRealizer(@Nullable String s) {
        GenericEdgeRealizer genericEdgeRealizer = graphManager.createGenericEdgeRealizer();
        genericEdgeRealizer.setArrow(Arrow.PLAIN);
        return genericEdgeRealizer;
    }

    @Override public @Nullable NodeCellEditor getCustomNodeCellEditor(@Nullable String s) {
        return null;
    }

    @Override public @Nullable String getNodeTooltip(@Nullable String s) {
        return null;
    }

    @Override public @Nullable String getEdgeTooltip(@Nullable String s) {
        return null;
    }

    @Override public boolean editNode(@Nullable String s) {
        return false;
    }

    @Override public boolean editEdge(@Nullable String s) {
        return false;
    }

    @Override public @NotNull DefaultActionGroup getNodeActionGroup(@Nullable String s) {
        return new DefaultActionGroup();
    }

    @Override public @NotNull DefaultActionGroup getEdgeActionGroup(@Nullable String s) {
        return new DefaultActionGroup();
    }

    @Override public @NotNull DefaultActionGroup getPaperActionGroup() {
        return new DefaultActionGroup();
    }

    @Override public EdgeLabel @NotNull [] getEdgeLabels(@Nullable String s, @NotNull String s2) {
        return new EdgeLabel[0];
    }

    @Override public @NotNull GraphSettings getSettings() {
        return graphSettings;
    }

    @Override public void customizeSettings(@NotNull Graph2DView graph2DView, @NotNull EditMode editMode) {

    }

    @Override public @NotNull EdgeCreationPolicy<String> getEdgeCreationPolicy() {
        return (EdgeCreationPolicy<String>) EdgeCreationPolicy.NOTHING_ACCEPTED_POLICY;
    }

    @Override public @Nullable DeleteProvider<?, ?> getDeleteProvider() {
        return null;
    }

    @Override public @NotNull String getActionPlace() {
        return ActionPlaces.POPUP;
    }

    @Override public void dispose() {

    }
}
