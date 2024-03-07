/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author tungl
 */
@Data
public class BienSoXe {

    private String bienSo;
    private String chuSoHuu;
    private String diaChiChuSoHuu;
    private Date ngayDangKy;
    private String status;
}
