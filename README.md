# Baba-is-us
Baba is us is a video game made for a school project. It is heavily inspired from Baba is you, and tries to expand the concept in multiplayer.

## Setup

First clone the repository.

To run from CLI, run `./gradlew desktop:run`.

To run from Eclipse, install the Buildship Gradle Integration plugin, then go to `File > Import > Gradle` and select the `core` folder.

For other IDE, check out the [libgdx documentation](https://libgdx.badlogicgames.com/documentation/gettingstarted/Importing%20into%20IDE.html)

## TODO List

### Setup

- [x]  Install libgdx on all our devices
- [ ]  Assign tasks

### Features

##### Levels

- [ ] Logic
- [ ] Event controller
- [ ] Level state storing
- [ ] Rendering
- [ ] Editor

##### Server/Client

- [ ] Client sockets
- [ ] Server sockets
- [ ] APIs

##### Navigation

- [ ] Menu navigation / Settings
- [ ] World navigation
- [ ] Level loading
- [ ] Player progression / level progression saving

### Other

- [ ] Graphical design
- [ ] Story
- [ ] Level design

## Specifications

### Controller API

`public User getUser();`

`public User getPartner();`

`public void sendEvent(Event event);`

`public boolean wasLevelUpdated(Event event);`

`public Event getUpdate(Event event);`

### Events

* `moveUp(User user);`
* `moveDown(User user);`
* `moveLeft(User user);`
* `moveRight(User user);`
* `zRequest(User user);`
* `zRequestStop(User user);`
* `rRequest(User user);`
* `rRequestStop(User user);`
* `wait(User user);`
