package com.hiroshi.restaurantapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hiros on 10/21/2017.
 */

public class Food {
    @SerializedName("id_makanan")
    int id;
    String nama;
    String deskripsi;
    int harga_beli;
    int harga_jual;
    String path;

    public Food(int id, String nama, String deskripsi, int harga_beli, int harga_jual) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga_beli = harga_beli;
        this.harga_jual = harga_jual;
    }

    public String getPath() {
        return path;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getHarga_beli() {
        return harga_beli;
    }

    public int getHarga_jual() {
        return harga_jual;
    }
}
