package org.example.models.response;

import org.example.models.pojo.Data;
import org.example.models.pojo.Meta;
import org.example.models.pojo.Support;

public class GetUsers {
    private Data data;
    private Support support;
    private Meta _meta;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public Meta get_meta() {
        return _meta;
    }

    public void set_meta(Meta _meta) {
        this._meta = _meta;
    }
}
