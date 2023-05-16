package course.work.database.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Сотрудник_поставщика")
public class SuppliersEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Фамилия")
    private String surname;

    @Column(name = "Имя")
    private String name;

    @Column(name = "Отчество")
    private String patronymic;

    @Column(name = "Должность")
    private String position;

    @Column(name = "Дата_рождения")
    private String dateOfBirth;

    @Column(name = "Адрес")
    private String address;

    @Column(name = "Сотовый_телефон")
    private String phoneNumber;

    @Column(name = "Электронный_адрес")
    private String email;

    @ManyToOne
    @JoinColumn(name = "компания_поставщика")
    private Supplier supplier;

}
