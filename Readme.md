Dynamic Widgets (Jetpack Compose)

Overview
This project implements a dynamic dashboard screen using Jetpack Compose, where widgets are rendered purely based on backend-provided metadata. The focus is on clean architecture, state management, and scalability, not UI polish or real networking.

What’s Implemented
Single Dashboard screen
Widgets rendered only from metadata
Two widget types:
Banner Widget (stateless, horizontal list)
List Widget (stateful: loading / success / error)
Supports multiple instances of the same widget type
Fake/static data only (no real APIs)


Architecture
MVVM
No business logic in composables
ViewModels manage all state
Each widget instance is scoped using instanceId
data/          
presentation/  
viewmodel/     


Widget Identity & State
Each widget instance is identified using:
WidgetType + instanceId
This key is used when creating ViewModels, ensuring state isolation and safe reuse of widgets.


Banner Widget
Stateless UI
Data driven by fake backend
Supports single or multiple banners
Rendered using LazyRow
Banner widgets are intentionally kept stateless since they do not require async or user-driven state.


List Widget
Fetches data independently per instance
Simulates API delay
Handles loading, success, and error states
State is fully isolated using instanceId


Assumptions
Metadata is always valid
UI is intentionally minimal
Focus is on architecture and reasoning


Future Improvements
Dependency Injection (Hilt)
Pagination for list widgets
Retry handling
UI polish and animations


How to Run
Clone the repo → Open in Android Studio → Run the app
Dashboard renders widgets dynamically on launch.
