Dynamic Widgets (Jetpack Compose)

Overview
- Dynamic dashboard screen built using Jetpack Compose
- Widgets are rendered **purely from backend metadata
- Focus on:
  - Clean architecture
  - State management
  - Scalability
- UI polish and real networking are intentionally out of scope

---

What’s Implemented
- Single Dashboard Screen
- Widgets rendered only from metadata
- Two widget types:
  - Banner Widget
    - Stateless
    - Horizontal list
  - List Widget
    - Stateful
    - Loading / Success / Error states
- Supports multiple instances of the same widget type**
- Uses **fake/static data** (no real APIs)

---

Architecture
- MVVM architecture
- No business logic inside composables
- ViewModels manage all state
- Each widget instance is scoped using `instanceId`

Package structure:
- `data/` → models and fake data sources
- `presentation/` → Compose UI
- `viewmodel/` → ViewModels

---

Widget Identity & State
- Each widget instance is uniquely identified by:
  - `WidgetType + instanceId`
- This key is used when creating ViewModels
- Ensures:
  - State isolation
  - Safe widget reuse
  - Support for multiple instances

---

Banner Widget
- Stateless UI component
- Data driven by fake backend
- Supports single or multiple banners
- Rendered using `LazyRow`
- Kept stateless since no async or user-driven state is required

---

List Widget
- Fetches data independently per instance
- Simulates API delay
- Handles:
  - Loading state
  - Success state
  - Error state
- State is fully isolated using `instanceId`

---

## Assumptions
- Backend metadata is always valid
- UI is intentionally minimal
- Focus is on architecture and reasoning

---

Future Improvements
- Dependency Injection (Hilt)
- Pagination for list widgets
- Retry handling
- UI polish and animations

---

How to Run
- Clone the repository
- Open in Android Studio
- Run the app
- Dashboard renders widgets dynamically on launch
