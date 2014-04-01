/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.irains.pushdemo.app.notify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.androidpn.client.Constants;
import org.androidpn.client.LogUtil;
import org.androidpn.client.Notifier;

import cn.irains.pushdemo.app.db.DBOperator;
import cn.irains.pushdemo.app.notify.NotifyIQ;

/** 
 * Broadcast receiver that handles push notification messages from the server.
 * This should be registered as receiver in AndroidManifest.xml. 
 * 
 * @author Geek_Solodad (msdx.android@qq.com)
 */
public final class NotifyReceiver extends BroadcastReceiver {

    private static final String LOGTAG = LogUtil
            .makeLogTag(NotifyReceiver.class);

    public static final String ACTION_SHOW_NOTIFICATION= "cn.irains.pushdemo.app.SHOW_NOTIFICATION";

    public NotifyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(LOGTAG, "NotifyReceiver.onReceive()...");
        String action = intent.getAction();
        Log.d(LOGTAG, "action=" + action);

        if (ACTION_SHOW_NOTIFICATION.equals(action)) {
            Object object = intent.getSerializableExtra(Constants.INTENT_EXTRA_IQ);
            if (object != null && object instanceof  NotifyIQ) {
                NotifyIQ iq = (NotifyIQ) object;

                Notifier notifier = new Notifier(context);
                notifier.notify(iq, iq.getTitle(), iq.getMessage());
                saveToDb(context, iq);
            }
        }
    }

    private void saveToDb(Context context, NotifyIQ iq) {
        DBOperator operator = new DBOperator(context);
        operator.saveIQ(iq);
    }

}
