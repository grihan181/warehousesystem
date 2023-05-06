package course.work.database.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Стеллаж")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Название")
    private String name;

    @Column(name = "Описание_местоположения")
    private String locationDescription;

    @ManyToOne
    @JoinColumn(name = "Сектор")
    private Sector sector;
}
