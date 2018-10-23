
package prociencia2.logic.model.charts;

import prociencia2.logic.core.entities.Seccion;
import prociencia2.logic.core.entities.Test;

/**
 *
 * @author Klac
 */
public class FactoryChartResource {
    
    public static org.jfree.chart.JFreeChart createPanelChartBar(Test test){
        
       org.jfree.data.category.DefaultCategoryDataset dataset = new org.jfree.data.category.DefaultCategoryDataset();
       for(Seccion seccion : test.getSecciones()){
            dataset.addValue(seccion.getSumatoria(), test.getNombre(), seccion.getNombreFormal());
       }
       org.jfree.chart.JFreeChart chart = org.jfree.chart.ChartFactory.createBarChart3D("Perfil de "+test.getNombre(), "Sección", "Nivel", dataset,
               org.jfree.chart.plot.PlotOrientation.VERTICAL, false, true, false);
       chart.getTitle().setPaint(new java.awt.Color(102, 102, 102));
       org.jfree.chart.plot.CategoryPlot plot = chart.getCategoryPlot();
       plot.setBackgroundPaint(java.awt.Color.WHITE);
       plot.setRangeGridlinePaint(chart.getTitle().getPaint());
       if(test.getNombre().compareTo("Intereses Ocupacionales") == 0)
           plot.getRangeAxis().setRange(0, 35);
       else
           plot.getRangeAxis().setRange(0, 25);
       plot.setBackgroundAlpha(.5f);
       plot.getRenderer().setBaseSeriesVisibleInLegend(true);
//        System.out.println(plot.getRangeAxisCount());
//        System.out.println(plot.getRangeCrosshairValue()+"\n"+plot.getWeight());
//       System.out.println(plot.getRangeCrosshairValue()+"\n"+plot.getRendererCount());
//        System.out.println(plot.getFixedRangeAxisSpace().getRight());
//        System.out.println(plot.getLegendItems().get(0).getLabel());

       return chart;
    }
    
    public static org.jfree.chart.JFreeChart createPanelChartLine(Test test){
        org.jfree.data.category.DefaultCategoryDataset dataset = 
                (org.jfree.data.category.DefaultCategoryDataset)createPanelChartBar(test).getCategoryPlot().getDataset();
        
        org.jfree.chart.JFreeChart chart = org.jfree.chart.ChartFactory.createLineChart3D("Perfil de "+test.getNombre(), "Sección", "Nivel", dataset,
               org.jfree.chart.plot.PlotOrientation.VERTICAL, false, true, false);
        chart.getTitle().setPaint(new java.awt.Color(102, 102, 102));
       org.jfree.chart.plot.CategoryPlot plot = chart.getCategoryPlot();
       plot.setBackgroundPaint(java.awt.Color.WHITE);
       plot.setRangeGridlinePaint(chart.getTitle().getPaint());
       plot.setDomainGridlinePaint(chart.getTitle().getPaint());
       plot.setDomainGridlinesVisible(true);
       if(test.getNombre().compareTo("Intereses Ocupacionales") == 0)
           plot.getRangeAxis().setRange(0, 35);
       else
           plot.getRangeAxis().setRange(0, 25);
       plot.setBackgroundAlpha(.5f);
       plot.getRenderer().setBaseSeriesVisibleInLegend(true);
       
       return chart;
    }
    
    public static org.jfree.chart.JFreeChart createPanelPieChart(Test test){
        org.jfree.data.general.DefaultPieDataset dataset = new org.jfree.data.general.DefaultPieDataset(); 
        for(Seccion secion: test.getSecciones()){
            dataset.setValue(secion.getNombreFormal(), secion.getSumatoria());
        }
        

        org.jfree.chart.JFreeChart chart = org.jfree.chart.ChartFactory.createPieChart3D("Perfil de "+test.getNombre(), dataset, false, true, false);
//        chart.setBackgroundPaint(new java.awt.GradientPaint(new java.awt.Point(0, 0), 
//                java.awt.Color.BLUE, new java.awt.Point(400, 200), java.awt.Color.WHITE));

        org.jfree.chart.title.TextTitle title = chart.getTitle();
        title.setPaint(new java.awt.Color(102, 102, 102));
        org.jfree.chart.plot.PiePlot plot = (org.jfree.chart.plot.PiePlot) chart.getPlot();
        plot.setBackgroundPaint(java.awt.Color.WHITE);
        plot.setInteriorGap(0.04);
        plot.setOutlineVisible(false);
        plot.setBackgroundAlpha(.5f);
        return chart;
    }
    
}
