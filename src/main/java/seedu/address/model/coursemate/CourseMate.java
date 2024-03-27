package seedu.address.model.coursemate;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.skill.Skill;

/**
 * Represents a CourseMate in the contact list.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class CourseMate {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Rating rating;

    // Data fields
    private final Set<Skill> skills = new HashSet<>();

    /**
     * A basic constructor for {@code CourseMate}.
     * Every field must be present and not null.
     */
    public CourseMate(Name name, Phone phone, Email email, Set<Skill> skills) {
        requireAllNonNull(name, phone, email, skills);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.skills.addAll(skills);
        this.rating = new Rating("0");
    }

    /**
     * A basic constructor for {@code CourseMate} that takes in a {@code Rating}.
     * Every field must be present and not null.
     */
    public CourseMate(Name name, Phone phone, Email email, Set<Skill> skills, Rating rating) {
        requireAllNonNull(name, phone, email, skills, rating);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.skills.addAll(skills);
        this.rating = rating;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Rating getRating() {
        return rating;
    }

    /**
     * Returns an immutable skill set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Skill> getSkills() {
        return Collections.unmodifiableSet(skills);
    }

    /**
     * Returns true if both course mates have the same name.
     * This defines a weaker notion of equality between two course mates.
     */
    public boolean isSameCourseMate(CourseMate otherCourseMate) {
        if (otherCourseMate == this) {
            return true;
        }

        return otherCourseMate != null
                && otherCourseMate.getName().equals(getName());
    }

    /**
     * Returns true if both course mates have the same identity and data fields.
     * This defines a stronger notion of equality between two course mates.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CourseMate)) {
            return false;
        }

        CourseMate otherCourseMate = (CourseMate) other;
        return name.equals(otherCourseMate.name)
                && phone.equals(otherCourseMate.phone)
                && email.equals(otherCourseMate.email)
                && rating.equals(otherCourseMate.rating)
                && skills.equals(otherCourseMate.skills);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, rating, skills);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("rating", rating)
                .add("skills", skills)
                .toString();
    }

}
