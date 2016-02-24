package com.example.pie_chart;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnchart=(Button) findViewById(R.id.button1);
        
        btnchart.setOnClickListener(
        		
        		new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				
				OpenChart();
			}
		}
        );
    }
    
    private void OpenChart()
    {
    	String[] subjects=new String[]{"Mathematics","Physics","Bio","English"};
    	
    	double[] distributions={2.8,5.9,10.5,4.3};
    	
    	int[] colors={Color.BLUE,Color.RED,Color.GREEN,Color.BLACK};
    	
    	CategorySeries category=new CategorySeries("Students Subjects Distribution");
    	
    	for(int i=0;i<distributions.length;i++)
    	{
    		
    		category.add(subjects[i],distributions[i]);
    		
    	}
    	
    	DefaultRenderer drenderer=new DefaultRenderer();
    	
    	for(int i=0;i<distributions.length;i++)
    	{
    		SimpleSeriesRenderer renderer=new SimpleSeriesRenderer();
    		renderer.setColor(colors[i]);
    		renderer.setDisplayChartValues(true);
    		
    		drenderer.addSeriesRenderer(renderer);
    	}   
    	
    	drenderer.setChartTitle("Pie chart for Subjects");
    	drenderer.setChartTitleTextSize(25);
    	//drenderer.setBackgroundColor(Color.BLACK);
    	drenderer.setZoomButtonsVisible(true);
    	drenderer.setLabelsColor(Color.BLACK);
    	drenderer.setLabelsTextSize(20);
    	drenderer.setBackgroundColor(Color.GRAY);
    	
    	Intent in=ChartFactory.getPieChartIntent(getBaseContext(),category , drenderer, "Pie Chart Demo");
    	startActivity(in);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    
}
