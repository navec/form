package fr.arolla.sample;

import org.junit.Ignore;
import org.junit.Test;

import java.nio.file.*;
import java.util.List;

/**
 *
 */
public class PathWatcherTest {

    @Test
    @Ignore
    public void should_watch_file_system() throws Exception {
        Path here = Paths.get(".");
        System.out.println(here.toAbsolutePath());
        WatchService watcher = here.getFileSystem().newWatchService();
        here.register(watcher, StandardWatchEventKinds.ENTRY_DELETE);
        WatchKey watckKey = watcher.take();
        List<WatchEvent<?>> events = watckKey.pollEvents();
        for (WatchEvent event : events) {
                System.out.println("Someone just do "+event.kind()+" on the file '" + event.context().toString() + "'.");
        }
    }

    @Test
    public void should_resolve_path(){
        Path here = Paths.get(".");
        System.out.println(here);
        System.out.println(here.toAbsolutePath());
        Path nouveauPath = here.toAbsolutePath().resolve("Temp/monfichier.txt");
        System.out.println(here);
        System.out.println(nouveauPath);
    }


    public <T extends Number> boolean isOdd(T value){
        return value.floatValue() % 2==0;
    }
}
