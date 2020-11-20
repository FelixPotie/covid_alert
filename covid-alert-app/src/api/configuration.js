export const apiUrl = 'http://localhost:8085/api/';

export const buildOrganizationApiUrl = (path) => {
  return `${apiUrl}${apiOrganizationUrlPath}${path}`;
};

