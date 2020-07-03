package nz.co.indepth.infinity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class MoviePO {
    private Long id;
    private String movieName;
    private BigDecimal price;
    @JsonIgnore
    private Long employeeId;
    @JsonIgnore
    private EmployeePO employeePO;

    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeePO getEmployeePO() {
        return employeePO;
    }

    public void setEmployeePO(EmployeePO employeePO) {
        this.employeePO = employeePO;
    }
}
