package cn.irains.pushdemo.app.db;/**
 * Created by msdx on 2014/3/26.
 */

/**
 * User: Geek_Soledad(msdx.android@qq.com)
 * Date: 2014-03-26
 * Time: 13:08
 * FIXME
 */
public interface DBConsts {

    String DB_NAME = "androidpn.db";
    int DB_VERSION = 1;

    String _ID = "_id";

    String TABLE_IQ = "t_iq";

    String COL_ID = "id";
    String COL_APIKEY = "apikey";
    String COL_TITLE = "title";
    String COL_MSG = "message";
    String COL_URI = "uri";

    String CREATE_TABLE_IQ = String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY, %s TEXT,  %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_IQ, _ID, COL_ID, COL_APIKEY, COL_TITLE, COL_MSG, COL_URI);
    String QUERY_ALL_IQ = String.format("SELECT %s, %s, %s, %s, %s, %s FROM %s ORDER BY %s desc", _ID, COL_ID, COL_APIKEY, COL_TITLE, COL_MSG, COL_URI, TABLE_IQ, _ID);
    String QUERY_IQ_BY_ID = String.format("SELECT %s, %s, %s, %s, %s, %s FROM %s WHERE %s=", _ID, COL_ID, COL_APIKEY, COL_TITLE, COL_MSG, COL_URI, TABLE_IQ, COL_ID);
    String QUERY_IQ_BY_TABLE_ID = String.format("SELECT %s, %s, %s, %s, %s, %s FROM %s WHERE %s=", _ID, COL_ID, COL_APIKEY, COL_TITLE, COL_MSG, COL_URI, TABLE_IQ, _ID);
}
