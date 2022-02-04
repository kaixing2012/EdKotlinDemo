package edward.project.shared.models

import edward.project.shared.enums.UserRoleEnum
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
        updatable = false
    )
    val email: String,

    @Column(
        name = "Age",
        nullable = false,
    )
    val age: Int,

    @Column(
        name = "IsActive",
        nullable = false,
    )
    val isActive: Boolean,

    @ElementCollection(targetClass=UserRoleEnum::class)
    @Enumerated(EnumType.STRING)
    @JoinTable(name = "UserRolesJoin")
    @Column(
        name = "Roles",
        columnDefinition = "TEXT",
        nullable = false,
    )
    val roles: List<UserRoleEnum>,



//    @ManyToMany(
//        fetch = FetchType.EAGER,
//        cascade = [CascadeType.ALL]
//    )
//    @JoinTable(
//        name = "UserAndRoleJoin",
//        joinColumns = [
//            JoinColumn(name = "UserJoinId", referencedColumnName = "Id")
//        ],
//        inverseJoinColumns = [
//            JoinColumn(name = "RoleJoinId", referencedColumnName = "Id")
//        ]
//    )
)
