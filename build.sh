mvn compile
cd jni
ant -f build-linux32-static.xml
cd ..
robovm -verbose -d native -cp target/classes:../libgdx/gdx/bin -libs GL:X11:jni/libgdx.a:jni/sdl/linux32/libSDL.a:libs/linux32/libgdx-backend-sdl.a SdlTest
