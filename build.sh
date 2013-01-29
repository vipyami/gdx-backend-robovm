cd jni
ant -f build-linux32-static.xml
cd ..
robovm -verbose -d native -cp bin:../libgdx/gdx/bin -static-libs GL:jni/libgdx.a:jni/sdl/linux32/libSDL.a:libs/linux32/libgdx-backend-sdl.a SdlTest
