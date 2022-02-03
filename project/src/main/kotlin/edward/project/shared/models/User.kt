package edward.project.shared.models

import javax.persistence.*

@Entity
@Table(
    name = "Users",
    uniqueConstraints = [
        UniqueConstraint(name = "UserEmailUnique", columnNames = ["Email"])
    ]
)
data class User(
    @Id
    @SequenceGenerator(
        name = "UserSeq",
        sequenceName = "UserSeq",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "UserSeq"
    )
    @Column(
        name = "Id",
        updatable = false
    )
    val id: Long = 0,

    @Column(
        name = "FirstName",
        columnDefinition = "TEXT",
        nullable = false,
    )
    val firstName: String,

    @Column(
        name = "LastName",
        columnDefinition = "TEXT",
        nullable = false,
    )
    val lastName: String,

    @Column(
        name = "Email",
        columnDefinition = "TEXT",
        nullable = false,
        insertable = false,
        updatable = false
    )
    val email: String,

    @Column(
        name = "Age",
        nullable = false,
    )
    var age: Int,

    @ManyToMany(
        fetch = FetchType.EAGER,
        cascade = [CascadeType.ALL]
    )
    @JoinTable(
        name = "UserAndRoleJoin",
        joinColumns = [
            JoinColumn(name = "UserJoinId", referencedColumnName = "Id")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "RoleJoinId", referencedColumnName = "Id")
        ]
    )
    val roles: MutableList<UserRole>,
)
