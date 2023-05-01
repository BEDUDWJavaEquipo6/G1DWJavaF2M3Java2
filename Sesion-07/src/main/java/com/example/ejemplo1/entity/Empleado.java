package com.example.ejemplo1.entity;
import lombok.*;
/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
*/
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "empleado")
@ToString
@Builder
public class Empleado {
    private String id;
    private String nombre;
}
