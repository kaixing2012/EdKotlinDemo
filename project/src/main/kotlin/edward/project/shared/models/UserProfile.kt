package edward.project.shared.models

import javax.persistence.*

@Entity
@Table(
    name = "UserProfiles",
    uniqueConstraints = [
        UniqueConstraint(
            name = "UserProfileUniques",
            columnNames = ["Email"]
        )
    ]
)
data class UserProfile(
    @Id
    @SequenceGenerator(
        name = "UserProfileSeq",
        sequenceName = "UserProfileSeq",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "UserProfileSeq"
    )
    @Column(
        name = "Id",
        updatable = false
    )
    val id: Long = 0,

    @Column(
        name = "FirstName",
        columnDefinition = "Text",
        nullable = false
    )
    val firstName: String,

    @Column(
        name = "LastName",
        columnDefinition = "Text",
        nullable = false
    )
    val lastName: String,

    @Column(
        name = "Email",
        columnDefinition = "TEXT",
        nullable = false,
        updatable = false
    )
    val email: String,

    @Column(
        name = "Age",
        nullable = false,
    )
    val age: Int
)
