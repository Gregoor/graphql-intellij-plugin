package graphql;

import com.intellij.notification.*;
import com.intellij.openapi.components.*;
import org.jetbrains.annotations.NotNull;

public class ApplicationComponentImpl implements ApplicationComponent {

    public static final NotificationGroup GROUP_DISPLAY_ID_INFO =
            new NotificationGroup("GraphQL", NotificationDisplayType.STICKY_BALLOON, true);

    @Override
    public void initComponent() {
        Notification notification = GROUP_DISPLAY_ID_INFO.createNotification(
            "Plugin: GraphQL",
            "This plugin is no longer maintained. Search for \"JS GraphQL\" for a better GraphQL plugin.",
            NotificationType.INFORMATION,
            null
        );
        notification.setImportant(true);
        Notifications.Bus.notify(notification);
    }

    @Override
    public void disposeComponent() {
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "GraphQL";
    }
}