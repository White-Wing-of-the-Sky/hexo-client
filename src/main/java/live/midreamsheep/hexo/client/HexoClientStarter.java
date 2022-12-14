package live.midreamsheep.hexo.client;

import live.midreamsheep.command.ApplicationStarter;
import live.midreamsheep.hexo.client.monitor.FileListener;
import live.midreamsheep.hexo.client.monitor.MonitorStarter;
import live.midreamsheep.hexo.netapi.data.Constant;
import live.midreamsheep.hexo.netapi.hand.net.ConnectorConfig;
import live.midreamsheep.hexo.netapi.message.queue.QueueApi;
import live.midreamsheep.hexo.netapi.message.queue.Task;
import live.midreamsheep.hexo.netapi.tool.io.SIO;

import java.io.File;

/**
 * @author midreamsheep
 * 启动器
 * */
public class HexoClientStarter {
    public static void main(String[] args) throws Exception {
        //配置文件读取
        ConnectorConfig.setConfig(SIO.read(System.getProperty("user.dir") + "\\config.properties"));
        //连接建立
        ConnectorConfig.init();
        //开始监听
        MonitorStarter monitorStarter = new MonitorStarter(1000);
        monitorStarter.monitor(new File(ConnectorConfig.nativeHexoPath+ Constant.blogPath).getPath(), new FileListener());
        monitorStarter.start();
        //开启守护线程监听任务
        TaskQueueStarter.start();
        //命令注入
        CommandStarter.start();
        //命令行启动
        ApplicationStarter.main(args);
    }
}