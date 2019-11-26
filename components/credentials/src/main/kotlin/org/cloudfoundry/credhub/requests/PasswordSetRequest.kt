package org.cloudfoundry.credhub.requests

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import javax.validation.Valid
import javax.validation.constraints.NotNull
import org.cloudfoundry.credhub.ErrorMessages
import org.cloudfoundry.credhub.credential.StringCredentialValue

class PasswordSetRequest : BaseCredentialSetRequest<StringCredentialValue?>() {

    @NotNull(message = ErrorMessages.MISSING_VALUE)
    @Valid
    @JsonProperty("value")
    var password: StringCredentialValue? = null
    @JsonIgnore
    override var generationParameters: StringGenerationParameters? = null

    override var credentialValue: StringCredentialValue? = null
        get() {
            return password
        }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val that = o as PasswordSetRequest?
        return password == that!!.password && generationParameters == that.generationParameters
    }

    override fun hashCode(): Int {
        return Objects.hash(password, generationParameters)
    }
}
