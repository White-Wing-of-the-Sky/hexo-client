package live.midreamsheep.hexo.client.monitor;


import live.midreamsheep.hexo.netapi.hand.net.ListenerApi;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

public class FileListener extends FileAlterationListenerAdaptor { 
    @Override
    public void onStart(FileAlterationObserver observer) {
        super.onStart(observer);
    }

    @Override
    public void onDirectoryCreate(File directory) {
        ListenerApi.directoryCreate(directory,false);
    }

    @Override
    public void onDirectoryDelete(File directory) {
        ListenerApi.directoryDelete(directory,false);
    }

    @Override
    public void onFileCreate(File file) {
        ListenerApi.fileCreate(file,false);
    }

    @Override
    public void onFileChange(File blogFile) {
        ListenerApi.fileChange(blogFile,false);
    }

    @Override
    public void onFileDelete(File file) {
        ListenerApi.fileDelete(file,false);
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        super.onStop(observer);
    }
}
