package com.example;

import com.intellij.openapi.graph.GraphManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.ComponentUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

import static com.intellij.openapi.graph.builder.GraphBuilderFactory.getInstance;

public class GraphPopupPostStartupActivity implements StartupActivity {

    public static final String HELLO = "Hello";
    public static final String WORLD = "World";

    @Override public void runActivity(@NotNull Project project) {

        var graphBuilderFactory = getInstance(project);
        var graphManager = GraphManager.getGraphManager();
        var graphDataModel = new MyCachedGraphDataModel();
        graphDataModel.buildGraph();

        var graphPresentationModel = new MyGraphPresentationModel(graphManager);
        var graphBuilder = graphBuilderFactory.createGraphBuilder(graphDataModel, graphPresentationModel);

        JComponent viewComponent = graphBuilder.getView().getJComponent();
        graphBuilder.initialize();
        JBPopupFactory.getInstance().createComponentPopupBuilder(viewComponent, viewComponent)
                .setProject(project)
                .setTitle("Hello World Graph")
                .setCancelOnClickOutside(false)
                .setCancelOnWindowDeactivation(false)
                .createPopup()
                .show(ComponentUtil.getActiveWindow());
    }

}
