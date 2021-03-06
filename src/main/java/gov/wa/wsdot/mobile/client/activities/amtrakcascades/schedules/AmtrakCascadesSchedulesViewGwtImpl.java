/*
 * Copyright (c) 2015 Washington State Department of Transportation
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */

package gov.wa.wsdot.mobile.client.activities.amtrakcascades.schedules;

import com.google.gwt.aria.client.Roles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.button.Button;
import com.googlecode.mgwt.ui.client.widget.header.HeaderTitle;
import com.googlecode.mgwt.ui.client.widget.input.listbox.MListBox;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FlexSpacer;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.progress.ProgressIndicator;
import gov.wa.wsdot.mobile.client.widget.button.image.BackImageButton;
import gov.wa.wsdot.mobile.shared.AmtrakCascadesStationItem;

import java.util.Collections;
import java.util.List;

public class AmtrakCascadesSchedulesViewGwtImpl extends Composite implements AmtrakCascadesSchedulesView {

	/**
	 * The UiBinder interface.
	 */	
	interface AmtrakCascadesSchedulesViewGwtImplUiBinder extends
			UiBinder<Widget, AmtrakCascadesSchedulesViewGwtImpl> {
	}

	/**
	 * The UiBinder used to generate the view.
	 */
	private static AmtrakCascadesSchedulesViewGwtImplUiBinder uiBinder = GWT
			.create(AmtrakCascadesSchedulesViewGwtImplUiBinder.class);
	
	@UiField
	HeaderTitle heading;

	@UiField
	BackImageButton backButton;
	
	@UiField
	ScrollPanel scrollPanel;
	
	@UiField
	FlexSpacer leftFlexSpacer;
	
    @UiField
    ProgressIndicator progressIndicator;
    
    @UiField(provided = true)
    MListBox daysOfWeek;
    
    @UiField(provided = true)
    MListBox fromLocation;
    
    @UiField(provided = true)
    MListBox toLocation;
    
    @UiField
    Button checkSchedules;
	
	private Presenter presenter;
	private DateTimeFormat dayOfWeekFormat = DateTimeFormat.getFormat("EEEE");
	private DateTimeFormat dateFormat = DateTimeFormat.getFormat("MMMM d, yyyy h:mm a");
	private DateTimeFormat statusDateFormat = DateTimeFormat.getFormat("yyyy-MM-dd");
	private boolean locationEnabled = false;
	
	public AmtrakCascadesSchedulesViewGwtImpl() {
	    
	    daysOfWeek = new MListBox();
	    fromLocation = new MListBox();
	    toLocation = new MListBox();
	
		initWidget(uiBinder.createAndBindUi(this));

		accessibilityPrepare();
		
        if (MGWT.getOsDetection().isAndroid()) {
            leftFlexSpacer.setVisible(false);
            scrollPanel.setBounce(false);
        }
	}

	@UiHandler("backButton")
	protected void onBackButtonPressed(TapEvent event) {
		if (presenter != null) {
			presenter.onBackButtonPressed();
		}
	}
	
	@UiHandler("checkSchedules")
	protected void onClick(TapEvent event) {
	    if (presenter != null) {
	        presenter.onSubmitButtonPressed();
	    }
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

    @Override
    public void showProgressIndicator() {
        progressIndicator.setVisible(true);
    }

    @Override
    public void hideProgressIndicator() {
        progressIndicator.setVisible(false);
    }

    @Override
    public void renderDaysOfWeek(List<String> days) {
        daysOfWeek.clear();
        
        for (String day: days) {
            daysOfWeek.addItem(dayOfWeekFormat.format(dateFormat.parse(day)),
                    statusDateFormat.format(dateFormat.parse(day)));
        }        
    }

    @Override
    public String getDayOfWeekSelected() {
        return daysOfWeek.getValue(daysOfWeek.getSelectedIndex());
    }

    @Override
    public void renderFromLocation(List<AmtrakCascadesStationItem> stations) {
        fromLocation.clear();
        
        if (!isLocationEnabled()) {
            fromLocation.addItem("Select your point of origin");
            fromLocation.getElement().<SelectElement>cast().getOptions().getItem(0).setDisabled(true);
        }

        for (AmtrakCascadesStationItem station: stations) {
            fromLocation.addItem(station.getStationName(), station.getStationCode());
        }
        
        int stationIndex = 0;
        if (isLocationEnabled()) {
            Collections.sort(stations, AmtrakCascadesStationItem.stationDistanceComparator);
            AmtrakCascadesStationItem closestStation = stations.get(0);
            Collections.sort(stations, AmtrakCascadesStationItem.stationNameComparator);
            stationIndex = stations.indexOf(closestStation);
        }
        
        fromLocation.setSelectedIndex(stationIndex);
    }
    
    @Override
    public void renderToLocation(List<AmtrakCascadesStationItem> stations) {
        toLocation.clear();
        toLocation.addItem("Select your destination (Optional)");
        toLocation.getElement().<SelectElement>cast().getOptions().getItem(0).setDisabled(true);
        
        for (AmtrakCascadesStationItem station: stations) {
            toLocation.addItem(station.getStationName(), station.getStationCode());
        }
        
        toLocation.setSelectedIndex(0);
    }

    @Override
    public String getFromLocationSelected() {
        int selectedIndex = fromLocation.getSelectedIndex();
        if (isLocationEnabled()) {
            if (selectedIndex == -1) {
                return "NA";
            } else {
                return fromLocation.getValue(selectedIndex);
            }
        } else {
            if (selectedIndex == 0 || selectedIndex == -1) {
                return "NA";
            } else {
                return fromLocation.getValue(selectedIndex);
            }            
        }
    }

    @Override
    public String getToLocationSelected() {
        int selectedIndex = toLocation.getSelectedIndex();
        if (selectedIndex == 0 || selectedIndex == -1) {
            return "NA";
        } else {
            return toLocation.getValue(selectedIndex);
        }
    }

    public boolean isLocationEnabled() {
        return locationEnabled;
    }

    @Override
    public void setLocationEnabled(boolean locationEnabled) {
        this.locationEnabled = locationEnabled;
    }
	private void accessibilityPrepare(){
		
		// Add ARIA roles for accessibility
		Roles.getButtonRole().set(backButton.getElement());
		Roles.getButtonRole().setAriaLabelProperty(backButton.getElement(), "back");
		
		Roles.getButtonRole().set(checkSchedules.getElement());
		
		Roles.getHeadingRole().set(heading.getElement());
		
		Roles.getMenuRole().set(daysOfWeek.getElement());
		Roles.getMenuRole().setAriaLabelProperty(daysOfWeek.getElement(), "select a departing day");
		Roles.getMenuRole().setTabindexExtraAttribute(daysOfWeek.getElement(), 0);	
		
		Roles.getMenuRole().set(fromLocation.getElement());
		Roles.getMenuRole().setAriaLabelProperty(fromLocation.getElement(), "select an origin");
		Roles.getMenuRole().setTabindexExtraAttribute(fromLocation.getElement(), 0);	
		
		Roles.getMenuRole().set(toLocation.getElement());
		Roles.getMenuRole().setTabindexExtraAttribute(toLocation.getElement(), 0);	
		
	}
}