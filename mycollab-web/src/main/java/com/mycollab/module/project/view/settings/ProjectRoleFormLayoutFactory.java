/**
 * Copyright © MyCollab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycollab.module.project.view.settings;

import com.mycollab.common.i18n.GenericI18Enum;
import com.mycollab.form.view.LayoutType;
import com.mycollab.module.user.accountsettings.localization.RoleI18nEnum;
import com.mycollab.vaadin.UserUIContext;
import com.mycollab.vaadin.ui.AbstractFormLayoutFactory;
import com.mycollab.vaadin.ui.FormContainer;
import com.mycollab.vaadin.web.ui.grid.GridFormLayoutHelper;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.data.HasValue;

/**
 * @author MyCollab Ltd.
 * @since 1.0
 */
public class ProjectRoleFormLayoutFactory extends AbstractFormLayoutFactory {
    private GridFormLayoutHelper informationLayout;

    @Override
    public AbstractComponent getLayout() {
        final FormContainer layout = new FormContainer();

        informationLayout = GridFormLayoutHelper.defaultFormLayoutHelper(LayoutType.ONE_COLUMN);
        layout.addSection(UserUIContext.getMessage(RoleI18nEnum.SECTION_INFORMATION), informationLayout.getLayout());
        return layout;
    }

    @Override
    protected HasValue<?> onAttachField(Object propertyId, final HasValue<?> field) {
        if (propertyId.equals("rolename")) {
            return informationLayout.addComponent(field, UserUIContext.getMessage(GenericI18Enum.FORM_NAME), 0, 0);
        } else if (propertyId.equals("description")) {
            return informationLayout.addComponent(field, UserUIContext.getMessage(GenericI18Enum.FORM_DESCRIPTION), 0, 1);
        }
        return null;
    }
}
