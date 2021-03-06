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

package gov.wa.wsdot.mobile.client.widget.image;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import gov.wa.wsdot.mobile.client.widget.image.LocalImageHolder.LocalImageHolderAppearance;

public class LocalImageHolderDefaultXHighAppearance implements
        LocalImageHolderAppearance {

    public interface Resources extends ClientBundle, Images {

        Resources INSTANCE = GWT.create(Resources.class);

        @Source("resources/ic_action_camera_xhdpi.png")
        ImageResource camera();

        @Source("resources/ic_action_camera_2_xhdpi.png")
        ImageResource camera2();
        
        @Source("resources/ic_action_location_xhdpi.png")
        ImageResource location();
        
        @Source("resources/ic_action_navigation_xhdpi.png")
        ImageResource navigation();
        
        @Source("resources/ic_action_rocket_xhdpi.png")
        ImageResource rocket();
        
        @Source("resources/ic_action_time_xhdpi.png")
        ImageResource time();

        @Source("resources/ic_action_warning_xhdpi.png")
        ImageResource warning();
        
        @Source("resources/ic_action_menu_xhdpi.png")
        ImageResource menu();
        
        @Source("resources/ic_action_previous_item_xhdpi.png")
        ImageResource back();

        @Source("resources/ic_action_star_xhdpi.png")
        ImageResource star();

        @Source("resources/ic_action_back_xhdpi.png")
        ImageResource backAndroid();
    }

    @Override
    public Images get() {
        return Resources.INSTANCE;
    }

}
