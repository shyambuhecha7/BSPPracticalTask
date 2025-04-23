# BSPPracticalTask
 
## Project Setup

### Prerequisites
- Android Studio Arctic Fox or higher
- JDK 11+
- Android SDK API Level 24+

### Clone Repository
```bash
git clone https://github.com/shyambuhecha7/BSPPracticalTask.git
cd task-management-system
```

### Build and Run
```bash
./gradlew clean build
./gradlew installDebug
```
Or run directly from Android Studio.

### Essential Commands
- `./gradlew lint` - Run code linting
- `./gradlew test` - Run unit tests
- `./gradlew connectedAndroidTest` - Run instrumentation tests

## Documentation

- **Dependency Injection**: Hilt
- **Networking**: Retrofit
- **Local Database**: Room
- **Image Loading**: Coil

---
# Architecture Overview

## 1. MVVM Pattern
- **Model**: Data classes representing tasks and associated entities.
- **ViewModel**: Provides data to UI and handles business logic.
- **View**: Activities and Fragments observing LiveData from ViewModels.

## 2. Modules
- **app**: Main application module containing UI and DI setup.
- **data**: Handles data sources (Retrofit, Room).
- **domain**: Contains use cases and repository interfaces.

## 3. Dependency Injection with Hilt
- Annotate Application with `@HiltAndroidApp`.
- Provide network and database modules using `@Module` and `@Provides`.

## 4. Networking with Retrofit
- Define API endpoints in Service interfaces.

## 5. Local Persistence with Room
- Define `Entity` data classes and `Dao` interfaces.
- Provide Room Database via Hilt.

## 6. Image Loading with Coil
- Use Coil's `ImageLoader` in RecyclerView adapters.

---
# Challenges & Solutions

- **Migrating complex JSON**: Used Retrofit with Moshi converter.
- **Data consistency**: Implemented Room migrations.
- **Image caching**: Configured Coil with memory and disk caching.

