package edward.project.shared.models

import org.hibernate.Hibernate
import javax.persistence.*


@Entity
@Table(
    name = "user",
    uniqueConstraints = [
        UniqueConstraint(name = "user_email_unique", columnNames = ["email"])
    ]
)
data class User (
    @Id
    @SequenceGenerator(
        name = "user_seq",
        sequenceName = "user_seq",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_seq"
    )
    @Column(
        name = "id",
        updatable = false
    )
    val id: Long = 0,

    @Column(
        name = "first_name",
        columnDefinition = "TEXT",
        nullable = false,
    )
    val firstName: String,

    @Column(
        name = "last_name",
        columnDefinition = "TEXT",
        nullable = false,
    )
    val lastName: String,

    @Column(
        name = "email",
        columnDefinition = "TEXT",
        nullable = false,
        insertable = false,
        updatable = false
    )
    val email: String,

    @Column(
        name = "role",
        columnDefinition = "TEXT",
        nullable = false,
    )
    val role: String,

    @Column(
        name = "age",
        nullable = false,
    )
    var age: Int,
)
