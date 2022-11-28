package com.example.examensao;

import java.util.List;

public class ganadores {
    private String status;
    private List<ListaGanadores> data;

    public ganadores(String status,List<ListaGanadores>data){
        this.status=status;
        this.data=data;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ListaGanadores> getData() {
        return data;
    }

    public void setData(List<ListaGanadores> data) {
        this.data = data;
    }
}
