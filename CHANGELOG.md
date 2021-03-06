# Change Log
All notable changes to this project will be documented in this file.
This project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased]

## [4.4.1] - 2016-08-17
- Fixed issue casuing sailing spaces for some Anacortes routes to be unavailable.

## [4.4.0] - 2016-07-18
### Added
- Safety rest areas to the traffic map.

## [4.3.2] - 2016-07-06
### Changed
- Added new toll rates for July 1, 2016.

## [4.3.1] - 2016-06-22
### Fixed
- Google Map Api fails to load. As of 2016-06-22 google maps API now requires an API key.
- App crashes when viewing ferry departures from a new schedule. No longer lets users select a day with no data. See this [issue](https://github.com/WSDOT/wsdot-wsf-schedule/issues/2) in our wsdot-wsf-schedule repo.

## [4.3.0] - 2016-06-17
### Added
- Can now favorite locations on traffic map. Can delete and edit names from favorites list.
- Clicking the my location button now drops a marker showing users location.

### Changed
- Seattle Alerts feature has been removed. Replacing it is "Alerts in This Area". Displays a list of alerts on screen.
- Moved Traffic Alerts, Go To Locations and Express Lanes into overflow menu activity.
- Camera icon on Traffic Map toolbar looks more like map icons now.

### Fixed
- Navigating back from a favorites list item now takes users back to the favorites list.
- Refreshing map before it has loaded caused a null pointer exception.
- Pull refresh in ferries, mountain passes and travel times activities will now refresh data even if cache time isn't up.
- New YouTube feed url.

## [4.2.1] - 2016-04-18
### Fixed
- Ad banner covers toolbar on orientation change.

## [4.2.0] - 2016-04-12
### Added 
- WSDOTjobs twitter account to twitter feeds.

## [4.1.0] - 2016-04-07
### Added
- Accessibility: Now supports reading and accessing content with VoiceOver.
At this time three-finger swipe gestures are not supported.

## [4.0.0] - 2016-03-15
### Added
- Added Google Analytics

### Fixed
- Added Train numbers 502 and 504

## [3.4.0] - 2016-02-24
### Added
- Added link to the Express Lanes schedule

### Changed
- New data feed endpoints for the app. Previous versions of the app will no longer receive updates after March 31, 2016

### Fixed
- YouTube feed so WSDOT videos are viewable again

## [3.3.0] - 2015-11-17
### Added
- Cameras at each terminal to Ferries schedule departure times. In some cases you can now see vehicles queued outside the tollbooths, which will subtract from the listed drive-up spaces available. 

### Fixed
- The ’null’ pop-up error which would occur when viewing Ferries schedule departure times.

## [3.2.0] - 2015-11-05
### Changed
- Icon and launch screen assets for iPhone 6s and 6s plus.
- Improved ad location and experience.

## [3.1.11] - 2015-10-16
### Fixed
- Restores the app to running fullscreen on iPhone5 and 6 devices.

## [3.1.10] - 2015-10-05
### Added
- Basic information about the I-405 toll rates.

## [3.1.9] - 2015-09-01
### Fixed
- Back button issue.
- Status bar not showing when in landscape view.

## [3.1.8] - 2015-08-21
### Added
- Joint Base Lewis-McChord (JBLM) traffic flow map.

## [3.1.7] - 2015-08-11
### Added
- Ferry crossing time to Route Schedules and Favorites display.

### Changed
- Updated new toll rates as of July 1, 2015.

## [3.1.2] - 2015-02-03
### Added
- Ads.

## [3.1.1] - 2015-01-26
### Added
- Amtrak Cascades activity to check train schedules and train status as well as purchase tickets.

## [3.0.1] - 2014-11-06
### Fixed
- “Location Services” bug.

## [3.0.0] - 2014-10-31
### Added
- Ferry schedules now include drive-up vehicle spaces available for departure times.
- Ferry schedules now only display upcoming departure times. Don’t show past sailings.

### Changed
- iOS 7/8 theme and higher resolution icons.

### Fixed
- Crashes and not being able to view all Mountain Pass cameras.

[Unreleased]: 
