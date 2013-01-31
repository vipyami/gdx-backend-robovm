gdx-backend-robovm
==================

An experimental robovm based backend for libgdx. uses SDL for window/input managment. Currently only tested on Linux (32-bit/64-bit JVM, 32-bit robovm)

You need robovm to be installed, see http://www.robovm.org

You'll need the libgdx sources to be installed next to the gdx-backend-robovm/ directory, e.g.

   gdx-backend-robovm/
   libgdx/

To import into Eclipse, run mvn eclipse:eclipse, you'll then have to also import gdx-jnigen into eclipse and add it as a project dependencies. I'll add
gdx-jnigen to our maven repo eventually so that dependency is not there anymore.

To build for robovm, run build.sh. You'll need mesa-common-dev and libgl1-mesa-dev and libglu1-mesa-dev installed
