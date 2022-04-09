import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author wencheng
 * @create 2022/3/28 19:40
 */
public class Test01 {
    private static String connectString = "hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;

    @Before
    public void init() throws Exception {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) { // 收到事件通知后的回调函数（用户的业务逻辑）
                System.out.println(event.getType() + "--" + event.getPath()); // 再次启动监听
                try {
                    zkClient.getChildren("/", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 创建子节点
    @Test
    public void create() throws Exception {
        //                                    要创建节点的路径   节点数据              节点权限                    节点类型
        String atguigu = zkClient.create("/atguigu", "jinlian".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(atguigu);

    }

    //获取子节点
    @Test
    public void getChildren() throws Exception {
        List<String> children = zkClient.getChildren("/", true);

        children.forEach(r-> System.out.println(r));
        Thread.sleep(Long.MAX_VALUE);
    }

    // 判断 znode 是否存在
    @Test public void exist() throws Exception {
        Stat stat = zkClient.exists("/eclipse", false);
        System.out.println(stat == null ? "not exist" : "exist");
    }
}
