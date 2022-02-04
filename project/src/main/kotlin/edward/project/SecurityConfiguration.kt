package edward.project

import edward.project.shared.enums.UserRoleEnum
import edward.project.shared.services.UserIdentityService

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userIdentityService: UserIdentityService
) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/api/v1/auth/admin").hasAnyRole(UserRoleEnum.ADMIN.toString())
            .antMatchers("/api/v1/auth/subscriber").hasAnyRole(UserRoleEnum.SUBSCRIBER.toString())
            .antMatchers("/api/v1/auth/non-subscriber").hasAnyRole(UserRoleEnum.NON_SUBSCRIBER.toString())
            .and()
            .httpBasic()
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val provider = DaoAuthenticationProvider()

        provider.setPasswordEncoder(passwordEncoder())
        provider.setUserDetailsService(userIdentityService)

        return provider
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}