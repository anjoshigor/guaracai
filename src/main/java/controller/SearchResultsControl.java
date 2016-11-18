package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Client;
import view.ClientRegisterView;
import view.SearchResultsView;
/**
 * 
 * @author alvesmarcos
 *
 */
public class SearchResultsControl {
	
	public SearchResultsControl(SearchResultsView searchResultsView){
		SearchResultsView searchResults = searchResultsView;
		
		searchResultsView.getResultTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
		    public void valueChanged(ListSelectionEvent event) {
		        int indexRow = searchResultsView.getResultTable().getSelectedRow();
		        
				if (indexRow > -1) {
					List<Object> o = (List<Object>) searchResults.getObjectList();
					new ClientRegisterView((Client) o.get(indexRow)).setVisible(true);
					
					searchResults.dispose();
		        }
		    }
		});
		
		searchResults.getLblImageButtonVoltar().addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) { }
			
			@Override
			public void mousePressed(MouseEvent e) { }
			
			@Override
			public void mouseExited(MouseEvent e) { }
			
			@Override
			public void mouseEntered(MouseEvent e) { }
			
			@Override
			public void mouseClicked(MouseEvent e) {
				searchResultsView.dispose();
			}
		});
	}
}
