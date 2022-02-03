package edward.project.shared.models

import javax.persistence.*

@Entity
@Table(
    name = "UserRoles",
    uniqueConstraints = [
        UniqueConstraint(name = "UserRoleNameUnique", columnNames = ["Name"])
    ]
)
data class UserRole (
    @Id
    @SequenceGenerator(
        name = "UserRoleSeq",
        sequenceName = "UserRoleSeq",
        allocationSize = 1,
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "UserRoleSeq"
    )
    @Column(
        name = "Id",
        updatable = false
    )
    val id: Long = 0,

    @Column(
        name = "Name",
        columnDefinition = "TEXT",
        nullable = false,
        insertable = false,
        updatable = false
    )
    val name: String,

    @ManyToMany(
        mappedBy = "roles",
        fetch = FetchType.LAZY
    )
    val users: List<User>
)