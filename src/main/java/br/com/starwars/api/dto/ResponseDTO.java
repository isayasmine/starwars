package br.com.starwars.api.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseDTO implements Serializable {
    private Integer count;
    private String next;
    private String previous;
    private List<PlanetsDTO> results;

    public ResponseDTO() {
    }

    public ResponseDTO(Integer count, String next, String previous, List<PlanetsDTO> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PlanetsDTO> getResults() {
        return results;
    }

    public void setResults(List<PlanetsDTO> results) {
        this.results = results;
    }
}
